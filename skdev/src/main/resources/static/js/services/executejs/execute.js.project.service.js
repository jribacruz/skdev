(function() {
	'use strict';

	angular.module("skdevMD").factory('executeJSProjectSV', executeJSProjectSV);

	executeJSProjectSV.$inject = [ '$log', '$http', '$location', 'executeJSConsoleSV' ];

	/**
	 * 
	 * @param $log
	 * @param $http
	 * @param projectSV
	 * @returns
	 */
	function executeJSProjectSV($log, $http, $location, executeJSConsoleSV) {
		$log.debug('[executeJSProjectSV] Inicializando... ');

		var origin = new URI($location.absUrl());

		var service = {
			createFile : createFile,
			createDir: createDir
		};
		
		/**
		 * 
		 * Cria um arquivo.
		 * 
		 */
		function createFile(project, eFile) {
			if(project && project.name) {
				var createFileURL = origin.segment([ 'skdev', 'api', 'projects', project.name , 'files' ]).href();
				return $http.post(createFileURL, eFile)
							.then(createFileComplete)
							.catch(createFileFailed);
				
				function createFileComplete(res) {
					executeJSConsoleSV.info(format('Arquivo {} criado com sucesso.', eFile.path),{
						invoker: '$project.createFile',
						details: [{
							header: 'content',
							content: eFile.content
						}]
					});
					return res;
				}
				function createFileFailed(error) {
					
				}
			}
			executeJSConsoleSV.error(format('Projeto não definido para criação do arquivo {}',eFile.path),{
				invoker: '$project.createFile'
			})
		}
		
		/**
		 * 
		 * Cria um diretório
		 * 
		 */
		function createDir(project, eDir) {
			if(project && project.name) {
				var createDirURL = origin.segment([ 'skdev', 'api', 'projects', project.name , 'directories' ]).href();
				return $http.post(createDirURL, eDir)
							.then(createDirComplete)
							.catch(createDirFailed);
				
				function createDirComplete(res) {
					executeJSConsoleSV.info(format('Diretório {} criado com sucesso.', eDir.path),{
						invoker: '$project.createDir'
					});
					return res;
				}
				
				function createDirFailed(error) {
					
				};
			}
			executeJSConsoleSV.error(format('Projeto não definido para criação do diretório {}',eDir.path),{
				invoker: '$project.createFile'
			});
		}

		return service;
	}

})();