(function() {
	'use strict';

	angular.module("skdevMD").factory('executeJSWorkspaceSV', executeJSWorkspaceSV);

	executeJSWorkspaceSV.$inject = [ '$log', '$http', '$location', 'executeJSConsoleSV' ];

	/**
	 * 
	 * @param $log
	 * @param $http
	 * @param projectSV
	 * @returns
	 */
	function executeJSWorkspaceSV($log, $http, $location, executeJSConsoleSV) {
		$log.debug('[executeJSWorkspaceSV] Inicializando... ');

		var origin = new URI($location.absUrl());

		var service = {
			createProject : createProject
		};

		return service;

		function createProject(project) {
			var createProject = origin.segment([ 'skdev', 'api', 'projects' ]).href();
			$log.debug('[workspaceSV] createProject : ' + createProject);
			return $http.post(createProject, project)
						.then(createProjectComplete)
						.catch(createProjectFailed);
			function createProjectComplete(res) {
				executeJSConsoleSV.info(format('projeto {} criado com sucesso.', res.data.name),{
					invoker: '$workspace.createProject'
				});
				return res.data;
			}
			function createProjectFailed(error) {
				
			}
		}

	}

})();