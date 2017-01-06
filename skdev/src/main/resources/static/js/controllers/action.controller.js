(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', '$mdToast' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @param $mdDialog
	 * @param actionDialog
	 * @param actionId
	 * @param $mdToast
	 * @returns
	 */
	function ActionCT($scope, $log, $http, $mdDialog, $mdToast) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		$scope.hide = hide;

		function hide() {
			$mdDialog.hide();
		}

	}
})();