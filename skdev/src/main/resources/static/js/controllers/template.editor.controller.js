(function() {
	'use strict';

	angular.module('skdevMD').controller('TemplateEditorCT', TemplateEditorCT);

	TemplateEditorCT.$inject = [ '$scope', '$log', '$mdSidenav', '$location', 'templateSV', '$mdDialog' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdSidenav
	 * @param $location
	 * @returns
	 */
	function TemplateEditorCT($scope, $log, $mdSidenav, $location, templateSV, $mdDialog) {
		$log.debug('[TemplateEditorCT] Inicializando...');
		var self = this;

		var templateEditor = {};

		self.template = {};

		self.createTemplate = createTemplate;

		self.hideTemplateEditor = hideTemplateEditor;

		self.hideTemplateInfo = hideTemplateInfo;

		self.editTemplateInfo = editTemplateInfo;

		self.saveTemplateInfo = saveTemplateInfo;
		
		self.saveTemplateContent = saveTemplateContent;

		self.editTemplateContent = editTemplateContent;
		
		init();

		function init() {
			angular.element(document).ready(function() {
				_initTemplateEditor()
			});
		}

		function _initTemplateEditor() {
			$log.debug('[TemplateEditorCT] Inicializando editor de templates...');
			templateEditor = CodeMirror(document.getElementById('templateEditor'), {
				mode : "handlebars",
				lineNumbers : true,
				theme : 'eclipse',
				styleActiveLine : true
			});
			templateEditor.setSize('100%', '100%');
		}

		function createTemplate() {
			$log.debug('[TemplateEditorCT] createTemplate')
			self.template = templateSV.newTemplate();
			_showTemplateInfo();
		}

		function editTemplateContent(template) {
			_showTemplateEditor(template);
		}

		function editTemplateInfo(template) {
			self.template = angular.copy(template);
			_showTemplateInfo();
		}

		function saveTemplateInfo() {
			if (self.template.id === 0) {
				self.action.templates[self.template.name] = self.template;
				_showTemplateEditor(self.template);
				return;
			}
			$log.debug('[TemplateEditorCT] Salvando informações do template.');
		}
		
		function saveTemplateContent() {
			if (self.template.id === 0) {
				var templateContent = editors['template'].getValue();
				self.template.content = templateContent;
				self.action.templates.push(angular.copy(self.template));
				hideTemplateEditor();
				return;
			}
		}

		function _showTemplateEditor(template) {
			$mdDialog.show({
				parent : angular.element(document.body),
				contentElement : '#templateEditorDialog',
				clickOutsideToClose : false
			});
			templateEditor.setValue(template.content);
		}

		function _showTemplateInfo() {
			$mdDialog.show({
				parent : angular.element(document.body),
				contentElement : '#templateInfoDialog',
				clickOutsideToClose : false
			});
		}

		function hideTemplateInfo() {
			$log.debug('[TemplateEditorCT] hideTemplateInfo.');
			self.template = null;
			$scope.templateInfoForm.$setPristine();
			$scope.templateInfoForm.$setUntouched()
			$mdDialog.hide();
		}

		function hideTemplateEditor() {
			$mdDialog.hide();
		}

	}
})();
