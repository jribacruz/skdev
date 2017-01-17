(function() {
	'use strict';

	angular.module('skdevMD').controller('WorkspaceCT', WorkspaceCT);

	WorkspaceCT.$inject = [ '$scope', '$log', '$mdDialog', 'httpSV', '$location', '$mdSidenav', 'notificationSV', 'actionSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdDialog
	 * @param httpSV
	 * @returns
	 */
	function WorkspaceCT($scope, $log, $mdDialog, httpSV, $location, $mdSidenav, notificationSV, actionSV) {
		$log.debug('[WorkspaceCT] Inicializando...');
		var self = this;

		self.projects = [];

		self.showNotification = showNotification;

		self.selectedAction = [];

		self.newAction = newAction;

		self.editAction = editAction;

		self.deleteAction = deleteAction;

		self.init = init;

		// init();

		function init() {
			httpSV.get('/projects').then(function(projects) {
				self.projects = projects;
			});
		}

		function showNotification(message) {
			notificationSV.show(message);
		}

		function newAction() {
			var action = actionSV.newAction();
			actionSV.showActionInfo(action).then(function(action) {
				actionSV.insert(action).then(function(res) {
					actionSV.goTo(res.data.id);
				});
			}, angular.noop);
		}

		function editAction(id) {
			actionSV.goTo(id);
		}

		function deleteAction(action) {
			// Appending dialog to document.body to cover sidenav in docs app
			var confirm = $mdDialog.confirm()
								   .title('Confirmação')
								   .textContent(format('Deseja excluir a ação {} ?', action.name))
								   .ok('Sim')
								   .cancel('Não');
			$mdDialog.show(confirm).then(function() {
				actionSV.deleteAction(action.id).then(function() {
					$scope.$broadcast('action.delete.success', action);
					notificationSV.show('Ação excluida com sucesso!');
				});
			}, angular.noop);
		}

	}
})();