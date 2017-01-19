(function() {
	'use strict';

	angular.module("skdevMD").factory('workspaceSV', workspaceSV);

	workspaceSV.$inject = [ '$log', '$location', '$http' ];

	/**
	 * 
	 * @param $log
	 * @param $resource
	 * @returns
	 */
	function workspaceSV($log, $location, $http) {
		$log.debug('[workspaceSV] Inicializando... ');

		var origin = new URI($location.absUrl());

		var service = {
			getProjects : getProjects
		}

		return service;

		/**
		 * Retorna todos os projetos do workspace.
		 */
		function getProjects() {
			var getProjectsURL = origin.segment([ 'skdev', 'api', 'projects' ]).href();
			$log.debug('[workspaceSV] getProjects : ' + getProjectsURL);
			return $http.get(getProjectsURL);
		}
	}

})();