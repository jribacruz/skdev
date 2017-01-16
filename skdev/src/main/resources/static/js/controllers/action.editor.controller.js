(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionEditorCT', ActionEditorCT);

	ActionEditorCT.$inject = [ '$scope', '$log', '$location', '$mdSidenav', 'actionSV', '$mdDialog', 'notificationSV',
			'dialogHTMLEditorSV', 'executeJSEditorSV', 'templateEditorSV', 'projectSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdSidenav
	 * @param $location
	 * @returns
	 */
	function ActionEditorCT($scope, $log, $location, $mdSidenav, actionSV, $mdDialog, notificationSV, dialogHTMLEditorSV,
			executeJSEditorSV, templateEditorSV, projectSV) {
		$log.debug('[ActionEditorCT] Inicializando...');
		var self = this;

		self.loading = true;

		self.action = {};

		self.save = save;

		self.hideActionInfo = hideActionInfo;

		self.sidenavRight = sidenavRight;

		self.saveStatus = false;

		self.runAction = runAction;
		
		self.projects = [];
		
		self.selectedProject = {};

		init();

		function init() {
			angular.element(document).ready(function() {
				executeJSEditorSV.init();
				dialogHTMLEditorSV.init();
				templateEditorSV.init();
				_loadOrCreateAction();
				$scope.$broadcast('action.editor.ready');
				$log.debug('[ActionEditorCT] event broadcast: action.editor.ready');
			});
		}

		function _loadOrCreateAction() {
			var id = URI($location.absUrl()).filename();
			if (!isNaN(id)) {
				actionSV.load(id).then(function(res) {
					self.action = res.data;
					dialogHTMLEditorSV.setValue(res.data.dialogHTML);
					executeJSEditorSV.setValue(res.data.executeJS);
					self.loading = false;
				});
				return;
			}
			self.action = actionSV.newAction();
			_showActionInfo();
			self.loading = false;
		}

		function _showActionInfo() {
			$mdDialog.show({
				parent : angular.element(document.body),
				contentElement : '#actionInfoDialog',
				clickOutsideToClose : false
			});
		}

		function save() {
			self.saveStatus = true;
			if (self.action.id == 0) {
				$log.debug('[ActionEditorCT] save/insert');
				actionSV.insert(self.action).then(function(res) {
					$mdDialog.hide();
					self.saveStatus = false;
					self.action = res.data;
					notificationSV.show('Ação salva com sucesso.');
				});
				return;
			}
			$log.debug('[ActionEditorCT] save/update');
			self.action.dialogHTML = dialogHTMLEditorSV.getValue();
			self.action.executeJS = executeJSEditorSV.getValue();
			actionSV.update(self.action).then(function(res) {
				notificationSV.show('Ação atualizado com sucesso.');
				self.saveStatus = false;
			});
		}

		function hideActionInfo() {
			self.loading = false;
			$mdDialog.hide();
		}

		function sidenavRight() {
			$mdSidenav('sidenav-right').toggle();
		}

		function runAction(eAction) {
			self.action.dialogHTML = dialogHTMLEditorSV.getValue();
			self.action.executeJS = executeJSEditorSV.getValue();
			_selectProject().then(function() {
				console.log(self.selectedProject);
				actionSV.run(eAction);
			}, function() {
				console.log('Cancel');
			})
		}
		
		function _selectProject() {
			return $mdDialog.show({
				parent : angular.element(document.body),
				templateUrl : '/skdev/partials/select.project.dialog.html',
				clickOutsideToClose : false,
				scope: $scope,
				preserveScope: true,
				controller: function SelectProjectCT($scope, $mdDialog, projectSV) {
					console.log('[SelectProjectCT] Inicializando...');
					
					$scope.projects = [];
					
					$scope.selectedProject = {};
					
					projectSV.findAll().then(function(res){
						$scope.projects = res.data;
					});
					
					$scope.select = function() {
						$scope.actionEditorCT.selectedProject = $scope.selectedProject;
						$mdDialog.hide();
					}
					
					$scope.cancel = function() {
						$mdDialog.cancel();
					}
				}
			});
		}

	}
})();
