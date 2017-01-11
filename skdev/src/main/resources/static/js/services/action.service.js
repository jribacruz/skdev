(function() {
	'use strict';

	angular.module("skdevMD").factory('actionSV', actionSV);

	actionSV.$inject = [ '$log', '$http', '$location' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function actionSV($log, $http, $location) {
		$log.debug('[actionSV] Inicializando... ');

		var action = function() {
			var self = this;
			self.name = "";
			self.description = "";
			self.dialogHTML = "";
			self.executeJS = "";
			self.templates = [];
			self.groups = [];
		}

		var service = {
			load : load,
			newAction : newAction
		};

		return service;

		function load(id) {
			var origin = new URI($location.absUrl());
			var loadActionURL = origin.segment(['skdev', 'api','actions', new String(id)]).href();
			$log.debug(format('[actionSV] load={}', loadActionURL));
			return $http.get(loadActionURL);
		}

		function newAction() {
			return new action();
		}
	}

})();