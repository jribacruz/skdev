(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionEditorCT', ActionEditorCT);

	ActionEditorCT.$inject = [ '$scope', '$log', '$mdDialog' ];

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
	function ActionEditorCT($scope, $log, $mdDialog) {
		$log.debug('[ActionEditorCT] Inicializando...');
		var self = this;

		var editors = {};
		
		self.runDialog = runDialog;

		init();

		function init() {
			$log.debug('[ActionEditorCT] Inicializando editor execute.js')
			angular.element(document).ready(function() {
				/*
				 * Inicializando o editor de dialog.
				 */
				editors['dialoghtml'] = CodeMirror(document.getElementById('dialoghtmlEditor'), {
					mode : "htmlmixed",
					lineNumbers : true,
					autoCloseTags : true,
					theme : 'eclipse',
					styleActiveLine: true
				});
				editors['dialoghtml'].setSize('100%', '100%');
				
				/*
				 * Inicializando o editor de action execute
				 */
				editors['executejs'] = CodeMirror(document.getElementById('executejsEditor'), {
					value : "$notification.show('Funcionou')",
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
					styleActiveLine: true
				});
				editors['executejs'].setSize('100%', '100%');
				
				editors['templates'] = CodeMirror(document.getElementById('templatesEditor'), {
					mode : "handlebars",
					lineNumbers : true,
					theme : 'eclipse',
					styleActiveLine: true
				});
				editors['templates'].setSize('100%', '100%');

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
	}
})();
