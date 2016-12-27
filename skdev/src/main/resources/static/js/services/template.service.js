(function() {
	'use strict';

	angular.module("skdevMD").factory('templateSV', templateSV);

	templateSV.$inject = [ '$log', 'httpSV' ];

	/**
	 * 
	 * @param $log
	 * @param $resource
	 * @returns
	 */
	function templateSV($log, httpSV) {
		$log.debug('[templateSV] Inicializando... ');

		/*
		 * Representação de um model ETemplate
		 */
		var ETemplate = function() {
			this.id = 0;
			this.name = "";
			this.content = "";
		}

		var service = {
			newETemplate : newETemplate
		}

		function newETemplate(name) {
			var template = new ETemplate();
			template.name = name;
			return template
		}

		return service;
	}

})();