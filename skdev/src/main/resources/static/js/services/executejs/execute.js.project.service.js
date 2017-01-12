(function() {
	'use strict';

	angular.module("skdevMD").factory('ExecuteJSProjectSV', ExecuteJSProjectSV);

	ExecuteJSProjectSV.$inject = [ '$log', '$http' ];

	/**
	 * 
	 * @param $log
	 * @param $resource
	 * @returns
	 */
	function ExecuteJSProjectSV($log, $http) {
		$log.debug('[ExecuteJSProjectSV] Inicializando... ');

		var service = {};
		
		function createFile(eFile) {
			
		}
		
		function createDir(eDir) {
			
		}

		return service;
	}

})();