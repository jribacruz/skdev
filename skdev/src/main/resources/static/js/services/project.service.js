(function() {
	'use strict';

	angular.module("skdevMD").factory('ProjectSV', ProjectSV);

	ProjectSV.$inject = [ '$log', '$resource' ];

	/**
	 * 
	 * @param $log
	 * @param $resource
	 * @returns
	 */
	function ProjectSV($log, $resource) {
		$log.debug('[ProjectSV] Inicializando... ');

		var selectedProject = {}

		var api = {
			setSelectedProject : setSelectedProject,
			getSelectedProject : getSelectedProject
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