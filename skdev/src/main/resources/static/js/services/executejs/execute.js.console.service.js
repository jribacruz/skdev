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
		
		var defaultOptions = {
			invoker: 'executeJS'	
		}

		var service = {
			info : info,
			error: error,
			subscribe : subscribe
		};

		return service;

		function info(text, options) {
			options = angular.merge({}, defaultOptions, options);
			angular.forEach(subscribers, function(cb) {
				cb({
					level : 'info',
					message : text,
					options: options
				});
			});
		}
		
		function error(text, options) {
			options = angular.merge({}, defaultOptions, options);
			angular.forEach(subscribers, function(cb) {
				cb({
					level : 'error',
					message : text,
					options: options
				});
			});
		}

		function subscribe(cb) {
			$log.debug('[executeJSConsoleSV] subscribe');
			subscribers.push(cb);
		}

	}

})();