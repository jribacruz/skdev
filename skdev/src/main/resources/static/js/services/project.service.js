(function() {
	'use strict';

	angular.module("skdevMD").factory('projectSV', projectSV);

	projectSV.$inject = [ '$log', '$resource' ];

	/**
	 * 
	 * @param $log
	 * @param $resource
	 * @returns
	 */
	function projectSV($log, $resource) {
		$log.debug('[projectSV] Inicializando... ');

		var selectedProject = {}

		var api = {
		}

		var resource = $resource('http://localhost:8080/skdev/api/projects/:id', {
			id : '@id'
		}, api);

		var service = {
			resource : resource,
			setSelectedProject : setSelectedProject,
			getSelectedProject : getSelectedProject
		}

		return service;

		function setSelectedProject(project) {
			selectedProject = project;
		}

		function getSelectedProject() {
			return selectedProject;
		}
	}

})();