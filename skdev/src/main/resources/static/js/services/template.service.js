(function() {
	'use strict';

	angular.module("skdevMD").factory('templateSV', templateSV);

	templateSV.$inject = [ '$log', '$mdToast' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function templateSV($log, $mdToast) {
		$log.debug('[templateSV] Inicializando... ');

		var service = {
		}
		

		return service;
	}

})();