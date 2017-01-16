(function() {
	'use strict';

	angular.module("skdevMD").factory('projectSV', projectSV);

	projectSV.$inject = [ '$log', '$resource', '$location', '$http' ];

	/**
	 * 
	 * @param $log
	 * @param $resource
	 * @returns
	 */
	function projectSV($log, $resource, $location, $http) {
		$log.debug('[projectSV] Inicializando... ');
		
		var origin = new URI($location.absUrl());

		var selectedProject = {}

		var api = {
		}

		var resource = $resource('http://localhost:8080/skdev/api/projects/:id', {
			id : '@id'
		}, api);

		var service = {
			resource : resource,
			setSelectedProject : setSelectedProject,
			getSelectedProject : getSelectedProject,
			findAll: findAll
		}

		return service;

		function setSelectedProject(project) {
			selectedProject = project;
		}

		function getSelectedProject() {
			return selectedProject;
		}
		
		function findAll() {
			var findAllProjectsURL = origin.segment(['skdev', 'api','projects']).href();
			return $http.get(findAllProjectsURL);
		}
	}

})();