(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log', '$http', '$mdDialog' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @returns
	 */
	function ActionCT($scope, $log, $http, $mdDialog) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;
		
		self.hide = hide;

		function hide() {
			$mdDialog.hide();
		}

	}
})();