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
		
		var origin = new URI($location.absUrl());
		
		var EAction = function() {
			var self = this;
			self.id = 0;
			self.name = "";
			self.description = "";
			self.dialogHTML = "";
			self.executeJS = "";
			self.templates = {};
			self.groups = [];
		}
		
		var service = {
			load : load,
			newAction : newAction,
			insert: insert,
			update: update
		};

		return service;

		function load(id) {
			var loadActionURL = origin.segment(['skdev', 'api','actions', new String(id)]).href();
			$log.debug(format('[actionSV] load={}', loadActionURL));
			return $http.get(loadActionURL);
		}

		function newAction() {
			return new EAction();
		}
		
		function insert(eAction) {
			var insertActionURL = origin.segment(['skdev', 'api','actions']).href();
			return $http.post(insertActionURL, eAction);
		}
		
		function update(eAction) {
			var updateActionURL = origin.segment(['skdev', 'api','actions', new String(eAction.id)]).href();
			return $http.put(updateActionURL, eAction);
		}
	}

})();