(function() {
	'use strict';

	angular.module('skdevMD').controller('TemplateEditorCT', TemplateEditorCT);

	TemplateEditorCT.$inject = [ '$scope', '$log', '$mdSidenav', '$location', 'templateSV', '$mdDialog', 'notificationSV', 'templateEditorSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdSidenav
	 * @param $location
	 * @returns
	 */
	function TemplateEditorCT($scope, $log, $mdSidenav, $location, templateSV, $mdDialog, notificationSV, templateEditorSV ) {
		$log.debug('[TemplateEditorCT] Inicializando...');
		var self = this;

		var templateEditor = {};

		self.templates = [];
		
		self.template = {};
		
		self.saveStatus = false;

		self.newTemplate = newTemplate;

		self.hideTemplateEditor = hideTemplateEditor;

		self.hideTemplateInfo = hideTemplateInfo;

		self.editTemplateInfo = editTemplateInfo;

		self.save = save;
		
		self.editTemplateContent = editTemplateContent;
		
		self.deleteTemplate = deleteTemplate;
		
		init();

		function init() {
		}
		
		$scope.$on('action.loaded', function(evt, data){
			$log.debug('[TemplateEditorCT] ((action.loaded))');
			self.templates = data.templates;
		}); 

		function newTemplate(actionId) {
			$log.debug('[TemplateEditorCT] createTemplate');
			self.template = templateSV.newTemplate();
			self.template.actionId = actionId;
			templateEditorSV.showTemplateInfo();
		}

		function editTemplateContent(template) {
			self.template = angular.copy(template);
			templateEditorSV.setValue(self.template.content);
			templateEditorSV.showTemplateEditor(template);
		}

		function editTemplateInfo(template) {
			self.template = angular.copy(template);
			templateEditorSV.showTemplateInfo();
		}

		function save(actionId) {
			self.saveStatus = true;
			if (self.template.id === 0) {
				$log.debug('[TemplateEditorCT] save/insert');
				templateSV.insert(actionId, self.template).then(function(res){
					$mdDialog.hide();
					self.saveStatus = false;
					self.template = res.data;
					self.templates.push(self.template);
					notificationSV.show('Template salvo com sucesso.');
					templateEditorSV.showTemplateEditor();
				});
				return;
			}
			$log.debug('[TemplateEditorCT] save/update');
			self.template.content = templateEditorSV.getValue();
			templateSV.update(self.template).then(function(res) {
				self.saveStatus = false;
				//$scope.actionEditorCT.action.templates[self.template.name] = self.template;
				notificationSV.show('Template atualizado com sucesso.');
				$mdDialog.hide();
			});
		}
				
		function deleteTemplate(template) {
			notificationSV.confirm(format('Deseja excluir o template: {} ?', template.name)).then(function() {
				templateSV.deleteTemplate(template.id).then(function(res) {
					var index = self.templates.indexOf(template);
					self.templates.splice(index, 1);
					notificationSV.show('Template excluído com sucesso.');
				});
			}, angular.noop);
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
