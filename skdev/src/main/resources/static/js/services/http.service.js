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
			
			$log.debug('[HttpSV] Method=GET, id='+id+', options='+JSON.stringify(options));
			
			dataHandlers[id].loader = true;
			options = options || {};
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
			var pathParams = options['pathParams'] || {};
			//console.log(dataHandlers[id].url);
			//console.log(pathParams);
			//console.log(format('http://localhost:8080/skdev/api/project/domain/classes/{id}', pathParams));
			var url = format(dataHandlers[id].url,pathParams);
			return url;
		}
		
		/**
		 * 
		 */
		function registerDataHandlers(dataHandlerArray) {
			angular.forEach(dataHandlerArray, function(dataHandler) {
				var dataHandlerTokens = dataHandler.split(':');
				var id = dataHandlerTokens[0];
				var url = dataHandlerTokens[1];
				var defaultLoaderState = angular.isDefined(dataHandlerTokens[2]) ? dataHandlerTokens[2] === 'true': false;
				dataHandlers[id] = {};
				dataHandlers[id].url = context+url;
				dataHandlers[id].loader = defaultLoaderState;
			});
			return dataHandlers;
		}
		

	}

})();