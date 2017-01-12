(function() {
	'use strict';

	angular.module("skdevMD").factory('templateSV', templateSV);

	templateSV.$inject = [ '$log', '$mdToast', '$location', '$http' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function templateSV($log, $mdToast, $location, $http) {
		$log.debug('[templateSV] Inicializando... ');
		
		var origin = new URI($location.absUrl());

		var ETemplate = function() {
			var self = this;
			self.id = 0;
			self.name = "";
			self.description = "";
			self.content = "";
			self.actionId = 0;
		}

		var service = {
			newTemplate : newTemplate,
			insert: insert,
			update: update
		}

		return service;

		function newTemplate() {
			return new ETemplate();
		}
		
		function insert(eTemplate) {
			var insertTemplateURL = origin.segment(['skdev', 'api','templates']).href();
			return $http.post(insertTemplateURL, eTemplate);
		}
		
		function update(eTemplate) {
			var updateTemplateURL = origin.segment(['skdev', 'api','templates', new String(eTemplate.id)]).href();
			return $http.put(updateTemplateURL, eTemplate);
		}
	}

})();