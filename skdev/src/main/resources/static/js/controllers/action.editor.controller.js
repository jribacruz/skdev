(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionEditorCT', ActionEditorCT);

	ActionEditorCT.$inject = [ '$scope', '$log', '$mdSidenav', '$location', 'actionSV', '$mdDialog' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdSidenav
	 * @param $location
	 * @returns
	 */
	function ActionEditorCT($scope, $log, $mdSidenav, $location, actionSV, $mdDialog) {
		$log.debug('[ActionEditorCT] Inicializando...');
		var self = this;

		var editors = {};

		self.action = {};

		self.template = {};

		self.createTemplate = createTemplate;
		
		self.hideTemplateEditor = hideTemplateEditor;

		init();

		function init() {

			angular.element(document).ready(function() {

				_initExecuteJSEditor();
				_initDialogHTMLEditor();
				_initTemplateEditor();
				_loadOrCreateAction();
				/*
				 * Inicializando o editor de templates.
				 */

			});
		}

		/*
		 * Inicializa o editor de action execute
		 */
		function _initExecuteJSEditor() {
			$log.debug('[ActionEditorCT] Inicializando editor executeJS...')
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
			$log.debug('[ActionEditorCT] Inicializando editor dialogHTML...');
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

		function _initTemplateEditor() {
			$log.debug('[ActionEditorCT] Inicializando editor de templates...');
			editors['templateEditor'] = CodeMirror(document.getElementById('templateEditor'), {
				mode : "handlebars",
				lineNumbers : true,
				theme : 'eclipse',
				styleActiveLine : true
			});
			editors['templateEditor'].setSize('100%', '100%');
		}

		function _loadOrCreateAction() {
			var id = URI($location.absUrl()).filename();
			if (!isNaN(id)) {
				actionSV.load(id).then(function(res) {
					self.action = res.data;
					editors['dialogHTML'].setValue(res.data.dialogHTML);
					editors['executeJS'].setValue(res.data.executeJS);
				});
				return;
			}
			self.action = actionSV.newAction();
		}

		function createTemplate() {
			$log.debug('[ActionEditorCT] createTemplate')
			self.template = actionSV.newTemplate();
			$mdDialog.show({
				parent : angular.element(document.body),
				contentElement : '#templateEditorDialog',
				clickOutsideToClose : false
			});
		}
		
		function hideTemplateEditor() {
			$mdDialog.hide();
		}

	}
})();
