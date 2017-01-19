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
		
		function getMainDomainEClasses(project) {
			var getMainDomainEClassesURL = origin.segment([ 'skdev', 'api', 'projects', project.name, 'main', 'domain', 'classes' ]).href();
			$log.debug('[workspaceSV] getMainDomainEClasses : ' + getMainDomainEClassesURL);
			return $http.get(getMainDomainEClassesURL);
		}

		return service;

	}

})();