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

	}
})();