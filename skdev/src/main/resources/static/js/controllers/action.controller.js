(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', 'actionPayload' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @returns
	 */
	function ActionCT($scope, $log, $http, $mdDialog, actionPayload) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		self.hide = hide;

		self.values = {};

		self.components = actionPayload.dialog.components;
		
		self.updateOnChange = updateOnChange;

		function hide() {
			$mdDialog.hide();
		}

		function updateOnChange(targetId) {

		}

	}
})();