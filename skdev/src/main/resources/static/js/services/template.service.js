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
		}

		var service = {
			newTemplate : newTemplate,
			insert: insert,
			update: update,
			deleteTemplate: deleteTemplate
		}

		return service;

		function newTemplate() {
			return new ETemplate();
		}
		
		function insert(actionId, eTemplate) {
			$log.debug('[templateSV] insert');
			var insertTemplateURL = origin.segment(['skdev', 'api','actions',new String(actionId) ,'templates']).href();
			return $http.post(insertTemplateURL, eTemplate);
		}
		
		function update(eTemplate) {
			$log.debug('[templateSV] update');
			var updateTemplateURL = origin.segment(['skdev', 'api','templates', new String(eTemplate.id)]).href();
			return $http.put(updateTemplateURL, eTemplate);
		}
		
		function deleteTemplate(id) {
			$log.debug('[templateSV] delete');
			var deleteTemplateURL = origin.segment(['skdev', 'api','templates', new String(id)]).href();
			return $http.delete(deleteTemplateURL);
		}
	}

})();