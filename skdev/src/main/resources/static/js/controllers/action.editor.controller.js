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

		self.hideTemplateInfo = hideTemplateInfo;

		self.editTemplateInfo = editTemplateInfo;

		self.saveTemplateInfo = saveTemplateInfo;

		self.editTemplateContent = editTemplateContent;
		
		self.saveActionInfo = saveActionInfo;
		
		self.hideActionInfo = hideActionInfo;

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
			editors['template'] = CodeMirror(document.getElementById('templateEditor'), {
				mode : "handlebars",
				lineNumbers : true,
				theme : 'eclipse',
				styleActiveLine : true
			});
			editors['template'].setSize('100%', '100%');
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
			_showActionInfo();
		}

		function _showActionInfo() {
			$mdDialog.show({
				parent : angular.element(document.body),
				contentElement : '#actionInfoDialog',
				clickOutsideToClose : false
			});
		}
		
		function saveActionInfo() {
			if(self.action.id == 0) {
				$mdDialog.hide();
				return;
			}
		}
		
		function hideActionInfo() {
			$mdDialog.hide();
		}

		function createTemplate() {
			$log.debug('[ActionEditorCT] createTemplate')
			self.template = actionSV.newTemplate();
			_showTemplateInfo();
		}

		function editTemplateContent(template) {
			_showTemplateEditor(template);
		}

		function editTemplateInfo(template) {
			self.template = template;
			_showTemplateInfo();
		}

		function saveTemplateInfo() {
			if (self.template.id == 0) {
				_showTemplateEditor(self.template);
				return;
			}
			$log.debug('[ActionEditorCT] Salvando informações do template.');
		}

		function _showTemplateEditor(template) {
			$mdDialog.show({
				parent : angular.element(document.body),
				contentElement : '#templateEditorDialog',
				clickOutsideToClose : false
			});
			editors['template'].setValue(template.content);
		}

		function _showTemplateInfo() {
			$mdDialog.show({
				parent : angular.element(document.body),
				contentElement : '#templateInfoDialog',
				clickOutsideToClose : false
			});
		}

		function hideTemplateInfo(templateInfoForm) {
			templateInfoForm.$setPristine();
			$mdDialog.hide();
		}

		function hideTemplateEditor() {
			$mdDialog.hide();
		}

	}
})();
