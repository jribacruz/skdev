(function() {
	'use strict';

	angular.module('skdevMD').controller('TemplateEditorCT', TemplateEditorCT);

	TemplateEditorCT.$inject = [ '$scope', '$log', '$mdSidenav', '$location', 'actionSV', '$mdDialog' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdSidenav
	 * @param $location
	 * @returns
	 */
	function TemplateEditorCT($scope, $log, $mdSidenav, $location, actionSV, $mdDialog) {
		$log.debug('[TemplateEditorCT] Inicializando...');
		var self = this;


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

		}

		function createTemplate() {
			$log.debug('[TemplateEditorCT] createTemplate')
			self.template = actionSV.newTemplate();
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
			editors['template'].setValue(template.content);
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
