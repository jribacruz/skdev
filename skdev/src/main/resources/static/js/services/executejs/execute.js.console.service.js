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
			console.log('info');
			angular.forEach(subscribers, function(cb) {
				console.log("--------------------");
				cb(text);
			});
		}

		function subscribe(cb) {
			console.log("subscribe");
			subscribers.push(cb);
		}

	}

})();