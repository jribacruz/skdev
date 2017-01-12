(function() {
	'use strict';

	angular.module('skdevMD').controller('TemplateEditorCT', TemplateEditorCT);

	TemplateEditorCT.$inject = [ '$scope', '$log', '$mdSidenav', '$location', 'templateSV', '$mdDialog', 'notificationSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdSidenav
	 * @param $location
	 * @returns
	 */
	function TemplateEditorCT($scope, $log, $mdSidenav, $location, templateSV, $mdDialog, notificationSV) {
		$log.debug('[TemplateEditorCT] Inicializando...');
		var self = this;

		var templateEditor = {};

		self.template = {};
		
		self.saveStatus = false;

		self.createTemplate = createTemplate;

		self.hideTemplateEditor = hideTemplateEditor;

		self.hideTemplateInfo = hideTemplateInfo;

		self.editTemplateInfo = editTemplateInfo;

		self.save = save;
		
		self.editTemplateContent = editTemplateContent;
		
		init();

		function init() {
			angular.element(document).ready(function() {
				$log.debug('[TemplateEditorCT] Inicializando editor de templates...');
				templateEditor = CodeMirror(document.getElementById('templateEditor'), {
					mode : "handlebars",
					lineNumbers : true,
					theme : 'eclipse',
					styleActiveLine : true
				});
				templateEditor.setSize('100%', '100%');
			});
		}

		function createTemplate(actionId) {
			$log.debug('[TemplateEditorCT] createTemplate');
			self.template = templateSV.newTemplate();
			self.template.actionId = actionId;
			_showTemplateInfo();
		}

		function editTemplateContent(template) {
			self.template = angular.copy(template);
			templateEditor.setValue(self.template.content);
			_showTemplateEditor(template);
		}

		function editTemplateInfo(template) {
			self.template = angular.copy(template);
			_showTemplateInfo();
		}

		function save() {
			self.saveStatus = true;
			if (self.template.id === 0) {
				$log.debug('[TemplateEditorCT] save/insert');
				templateSV.insert(self.template).then(function(res){
					$mdDialog.hide();
					self.saveStatus = false;
					self.template = res.data;
					$scope.actionEditorCT.action.templates[self.template.name] = self.template;
					notificationSV.show('Template salvo com sucesso.');
					_showTemplateEditor();
				});
				return;
			}
			$log.debug('[TemplateEditorCT] save/update');
			self.template.content = templateEditor.getValue();
			templateSV.update(self.template).then(function(res) {
				self.saveStatus = false;
				notificationSV.show('Template atualizado com sucesso.');
				$mdDialog.hide();
			});
		}
		
		function _showTemplateEditor() {
			$mdDialog.show({
				parent : angular.element(document.body),
				contentElement : '#templateEditorDialog',
				clickOutsideToClose : false
			});
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
			$scope.templateInfoForm.$setUntouched();
			$mdDialog.hide();
		}

		function hideTemplateEditor() {
			$mdDialog.hide();
		}

	}
})();
