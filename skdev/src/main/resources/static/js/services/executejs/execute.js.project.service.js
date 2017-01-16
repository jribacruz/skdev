(function() {
	'use strict';

	angular.module("skdevMD").factory('ExecuteJSProjectSV', ExecuteJSProjectSV);

	ExecuteJSProjectSV.$inject = [ '$log', '$http', 'projectSV' ];

	/**
	 * 
	 * @param $log
	 * @param $http
	 * @param projectSV
	 * @returns
	 */
	function ExecuteJSProjectSV($log, $http, projectSV) {
		$log.debug('[ExecuteJSProjectSV] Inicializando... ');
		
		var origin = new URI($location.absUrl());
		
		var service = {};
		
		function createFile(eFile) {
			var createFileURL = format('/skdev/api/{}/files', projectSV.getSelectedProject().name);
			return $http.post(createFileURL, eFile);
		}
		
		function createDir(eDir) {
			
		}

		return service;
	}

})();