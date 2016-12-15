(function() {
	'use strict';

	angular.module("skdevMD").factory('HttpSV', HttpSV);

	HttpSV.$inject = [ '$log', '$http', '$location' ];

	/**
	 * 
	 * @param $log
	 * @param $http
	 * @param $location
	 * @returns
	 */
	function HttpSV($log, $http, $location) {
		$log.debug('[HttpSV] Inicializando... ');
		
		var context = 'http://' + $location.host() + ':' + $location.port() + '/skdev/api';

		var dataHandlers = {};

		var service = {
			get : get,
			registerDataHandlers: registerDataHandlers
		}
		

		return service;
		
		/**
		 * Função Http GET
		 */
		function get(id, options) {
			
			dataHandlers[id].loader = true;
			var urlRequest = buildUrlRequest(id, options);
			
			return $http.get(urlRequest)
				.then(httpComplete)
				.catch(httpFailure);
			
			function httpComplete(response) {
				dataHandlers[id].data = response.data;
				dataHandlers[id].loader = false;
				return response.data;
			}
			
			function httpFailure(error) {
				dataHandlers[id].loader = false;
				$log.debug('Request failed');
			}
		}
		
		function buildUrlRequest(id,options) {
			return dataHandlers[id].url;
		}
		
		/**
		 * 
		 */
		function registerDataHandlers(dataHandlerArray) {
			// console.log("[registerDataHandlers] Begin..");
			angular.forEach(dataHandlerArray, function(dataHandler) {
				var dataHandlerTokens = dataHandler.split(':');
				// console.log(dataHandlerTokens)
				var id = dataHandlerTokens[0];
				var url = dataHandlerTokens[1];
				// console.log('1')
				var defaultLoaderState = angular.isDefined(dataHandlerTokens[2]) ? dataHandlerTokens[2] === 'true': false;
				// console.log('2')
				dataHandlers[id] = {};
				dataHandlers[id].url = context+url;
				// console.log('3')
				dataHandlers[id].loader = defaultLoaderState;
				// console.log('4')
			});
			// console.log("[registerDataHandlers] End.. " + dataHandlers);
			return dataHandlers;
		}
		

	}

})();