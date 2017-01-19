(function() {
	'use strict';

	angular.module("skdevMD").factory('projectSV', projectSV);

	projectSV.$inject = [ '$log', '$location', '$http' ];

	/**
	 * 
	 * @param $log
	 * @param $resource
	 * @returns
	 */
	function projectSV($log, $location, $http) {
		$log.debug('[projectSV] Inicializando... ');

		var origin = new URI($location.absUrl());

		var service = {
		}

		return service;

	}

})();