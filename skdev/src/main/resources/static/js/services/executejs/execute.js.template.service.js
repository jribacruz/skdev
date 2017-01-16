(function() {
	'use strict';

	angular.module("skdevMD").factory('executeJSTemplateSV', executeJSTemplateSV);

	executeJSTemplateSV.$inject = [ '$log', '$http' ];

	/**
	 * 
	 * @param $log
	 * @param $resource
	 * @returns
	 */
	function executeJSTemplateSV($log, $http) {
		$log.debug('[executeJSTemplateSV] Inicializando... ');

		var service = {
			merge : merge
		};

		return service;

		function merge(template, model) {
			if(angular.isObject(template)) {
				$log.debug('[executeJSTemplateSV] merge/object')
				var template = Handlebars.compile(template.content);
				return template(model);
			}
			var template = Handlebars.compile(template);
			return template(model);
		}

	}

})();