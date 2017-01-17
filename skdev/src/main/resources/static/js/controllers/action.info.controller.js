(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionInfoCT', ActionInfoCT);

	ActionInfoCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', 'actionSV', 'action' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @param $mdDialog
	 * @param HttpSV
	 * @returns
	 */
	function ActionInfoCT($scope, $log, $http, $mdDialog, actionSV, action) {
		$log.debug('[ActionInfoCT] Inicializando...');
		var self = this;

		self.action = action;

		self.cancel = cancel;

		self.save = save;

		function cancel() {
			$mdDialog.cancel();
		}

		function save() {
			$mdDialog.hide(self.action);
		}

	}
})();