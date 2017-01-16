(function() {
	'use strict';

	angular.module("skdevMD").factory('executeJSProjectSV', executeJSProjectSV);

	executeJSProjectSV.$inject = [ '$log', '$http', 'projectSV', '$location' ];

	/**
	 * 
	 * @param $log
	 * @param $http
	 * @param projectSV
	 * @returns
	 */
	function executeJSProjectSV($log, $http, projectSV, $location) {
		$log.debug('[executeJSProjectSV] Inicializando... ');

		var origin = new URI($location.absUrl());

		var service = {
			createFile : createFile
		};

		function createFile(eFile) {
			var createFileURL = origin.segment([ 'skdev', 'api', 'projects', projectSV.getSelectedProject().name , 'files' ]).href();
			return $http.post(createFileURL, eFile);
		}

		function createDir(eDir) {

		}

		return service;
	}

})();