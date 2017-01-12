(function() {
	'use strict';

	angular.module("skdevMD").factory('templateSV', templateSV);

	templateSV.$inject = [ '$log', '$mdToast', '$location' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function templateSV($log, $mdToast, $location) {
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
			newTemplate : newTemplate
		}

		return service;

		function newTemplate() {
			return new ETemplate();
		}
	}

})();