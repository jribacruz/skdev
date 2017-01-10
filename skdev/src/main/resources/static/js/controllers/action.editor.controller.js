(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionEditorCT', ActionEditorCT);

	ActionEditorCT.$inject = [ '$scope', '$log'];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param ProjectSV
	 * @param $mdDialog
	 * @param $http
	 * @param HttpSV
	 * @returns
	 */
	function ActionEditorCT($scope, $log) {
		$log.debug('[ActionEditorCT] Inicializando...');
		var self = this;

		var editors = {};

		self.runDialog = runDialog;

		self.showTemplates = showTemplates;

		init();

		function init() {
			$log.debug('[ActionEditorCT] Inicializando editor execute.js')
			angular.element(document).ready(function() {
				/*
				 * Inicializando o editor de configuração.
				 */
				/*
				editors['configjson'] = CodeMirror(document.getElementById('configjsonEditor'), {
					mode : "application/json",
					lineNumbers : true,
					autoCloseBrackets : true,
					gutters : [ "CodeMirror-lint-markers" ],
					lint : true,
					indentUnit : 4,
					theme : 'eclipse',
					styleActiveLine : true
				});
				editors['configjson'].setSize('100%', '100%');
				*/
				/*
				 * Inicializando o editor de dialog.
				 */
				
				editors['dialoghtml'] = CodeMirror(document.getElementById('dialoghtmlEditor'), {
					mode : "htmlmixed",
					lineNumbers : true,
					autoCloseTags : true,
					gutters : [ "CodeMirror-lint-markers" ],
					theme : 'eclipse',
					styleActiveLine : true
				});
				editors['dialoghtml'].setSize('100%', '100%');
				

				/*
				 * Inicializando o editor de action execute
				 */
				editors['executejs'] = CodeMirror(document.getElementById('executejsEditor'), {
					mode : "javascript",
					lineNumbers : true,
					gutters : [ "CodeMirror-lint-markers" ],
					lint : true,
					autoCloseBrackets : true,
					extraKeys : {
						"Ctrl-Space" : "autocomplete"
					},
					matchBrackets : false,
					theme : 'eclipse',
					indentUnit : 4,
					styleActiveLine : true
				});
				editors['executejs'].setSize('100%', '100%');
				
				/*
				 * Inicializando o editor de templates.
				 */
				/*
				editors['templates'] = CodeMirror(document.getElementById('templatesEditor'), {
					mode : "handlebars",
					lineNumbers : true,
					theme : 'eclipse',
					styleActiveLine : true
				});
				editors['templates'].setSize('100%', '100%');
				*/

			});
		}

		function runDialog() {
			console.log(editors['dialoghtml'].getValue());
			$mdDialog.show({
				parent : angular.element(document.body),
				template : editors['dialog'].getValue(),
				clickOutsideToClose : false,
				controller : 'ActionCT'
			});
		}

		function showTemplates() {
			$mdSidenav('sidenav').toggle();
		}
	}
})();
