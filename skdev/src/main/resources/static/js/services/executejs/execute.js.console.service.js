(function() {
	'use strict';

	angular.module("skdevMD").factory('executeJSConsoleSV', executeJSConsoleSV);

	executeJSConsoleSV.$inject = [ '$log', '$http' ];

	/**
	 * 
	 * @param $log
	 * @param $resource
	 * @returns
	 */
	function executeJSConsoleSV($log, $http) {
		$log.debug('[executeJSConsoleSV] Inicializando... ');

		var subscribers = [];

		var service = {
			info : info,
			subscribe : subscribe
		};

		return service;

		function info(text) {
			angular.forEach(subscribers, function(cb) {
				cb(text);
			});
		}

		function subscribe(cb) {
			$log.debug('[executeJSConsoleSV] subscribe');
			subscribers.push(cb);
		}

	}

})();