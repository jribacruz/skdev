(function() {
	'use strict';

	angular.module("skdevMD").factory('executeJSProjectSV', executeJSProjectSV);

	executeJSProjectSV.$inject = [ '$log', '$http', 'projectSV', '$location', 'executeJSConsoleSV' ];

	/**
	 * 
	 * @param $log
	 * @param $http
	 * @param projectSV
	 * @returns
	 */
	function executeJSProjectSV($log, $http, projectSV, $location, executeJSConsoleSV) {
		$log.debug('[executeJSProjectSV] Inicializando... ');

		var origin = new URI($location.absUrl());

		var service = {
			createFile : createFile
		};
		
		/**
		 * 
		 * Cria um arquivo.
		 * 
		 */
		function createFile(eFile) {
			var createFileURL = origin.segment([ 'skdev', 'api', 'projects', projectSV.getSelectedProject().name , 'files' ]).href();
			return $http.post(createFileURL, eFile)
						.then(createFileComplete)
						.catch(createFileFailed);
			
			function createFileComplete(res) {
				executeJSConsoleSV.info('Arquivo criado com sucesso.',{
					invoker: '$project.createFile',
					details: [{
						header: 'path',
						content: eFile.path
					},{
						header: 'content',
						content: eFile.content
					}]
				});
				return res;
			}
			
			function createFileFailed(error) {
				
			}
		}
		
		/**
		 * 
		 * Cria um diretório
		 * 
		 */
		function createDir(eDir) {
			var createDirURL = origin.segment([ 'skdev', 'api', 'projects', projectSV.getSelectedProject().name , 'directories' ]).href();
			return $http.post(createDirURL, eFile);
		}

		return service;
	}

})();