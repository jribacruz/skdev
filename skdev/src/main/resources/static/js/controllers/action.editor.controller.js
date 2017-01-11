(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionEditorCT', ActionEditorCT);

	ActionEditorCT.$inject = [ '$scope', '$log', '$mdSidenav', '$location', 'actionSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdSidenav
	 * @param $location
	 * @returns
	 */
	function ActionEditorCT($scope, $log, $mdSidenav, $location, actionSV) {
		$log.debug('[ActionEditorCT] Inicializando...');
		var self = this;

		var editors = {};

		self.action = {};

		self.runDialog = runDialog;

		init();

		function init() {

			angular.element(document).ready(function() {

				_initExecuteJSEditor();
				_initDialogHTMLEditor();
				_loadOrCreateAction();
				/*
				 * Inicializando o editor de templates.
				 */
				/*
				 * editors['templates'] =
				 * CodeMirror(document.getElementById('templatesEditor'), { mode :
				 * "handlebars", lineNumbers : true, theme : 'eclipse',
				 * styleActiveLine : true });
				 * editors['templates'].setSize('100%', '100%');
				 */

			});
		}

		/*
		 * Inicializa o editor de action execute
		 */
		function _initExecuteJSEditor() {
			$log.debug('[ActionEditorCT] Inicializando editor executeJS')
			editors['executeJS'] = CodeMirror(document.getElementById('executeJSEditor'), {
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
			editors['executeJS'].setSize('100%', '100%');
		}

		function _initDialogHTMLEditor() {
			$log.debug('[ActionEditorCT] Inicializando editor dialogHTML')
			editors['dialogHTML'] = CodeMirror(document.getElementById('dialogHTMLEditor'), {
				mode : "htmlmixed",
				lineNumbers : true,
				autoCloseTags : true,
				gutters : [ "CodeMirror-lint-markers" ],
				theme : 'eclipse',
				styleActiveLine : true
			});
			editors['dialogHTML'].setSize('100%', '100%');
		}

		function _loadOrCreateAction() {
			var id = URI($location.absUrl()).filename();
			if (id) {
				actionSV.load(id).then(function(data) {
					self.action = data;	
				});
			}
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
