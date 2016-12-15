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
		
		var context = format('http://{}:{}/skdev/api',$location.host(),$location.port());

		var dataHandlers = {};

		var service = {
			get : get,
			$dh: $dh,
		}
		

		return service;
		
		/**
		 * Função Http GET
		 */
		function get(id, options) {
			
			$log.debug(format('[HttpSV] Method=GET, URL={} , id={}, options={}', dataHandlers[id].url ,id,JSON.stringify(options)));
			
			dataHandlers[id].loader = true;
			options = options || {};
			var urlRequest = _buildUrlRequest(id, options);
			
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
		
		/**
		 * 
		 */
		function _buildUrlRequest(id,options) {
			var url = dataHandlers[id].url;
			url = _buildUrlPathParams(url,options);
			$log.debug(format('[HttpSV] buildUrlPathParams={}',url));
			url = _buildUrlQueryParams(url,options);
			$log.debug(format('[HttpSV] buildUrlQueryParams={}',url));
			return url;
		}
		
		/**
		 * 
		 */
		function _buildUrlPathParams(url,options) {
			var pathParams = options['pathParams'] || {};
			return format(url,pathParams);
		}
		
		/**
		 * 
		 */
		function _buildUrlQueryParams(url,options) {
			if(options['queryParams']) {
				var qArray = [];
				angular.forEach(options.queryParams, function(qryParam, id) {
					qArray.push(format('{}={}', id, qryParam));
				});
				if(url.endsWith('/')) {
					return format('{}{}',url,qArray.join('&'));
				}
				return format('{}/{}',url,qArray.join('&'));
			}
			return url;
		}
		
		/**
		 * 
		 */
		function $dh(dataHandlerArray) {
			if(angular.isArray(dataHandlerArray)) {
				angular.forEach(dataHandlerArray, function(dataHandler) {
					var dataHandlerTokens = dataHandler.split(':');
					var id = dataHandlerTokens[0];
					var url = dataHandlerTokens[1];
					var defaultLoaderState = angular.isDefined(dataHandlerTokens[2]) ? dataHandlerTokens[2] === 'true': false;
					dataHandlers[id] = {};
					dataHandlers[id].url = context+url;
					dataHandlers[id].loader = defaultLoaderState;
					$log.debug(format('[HttpSV] register $dh={}', JSON.stringify(dataHandlers[id])));
				});
				return dataHandlers;
			}
			if(angular.isString(dataHandlerArray)) {
				if(angular.isDefined(dataHandlers[dataHandlerArray])) {
					return dataHandlers[dataHandlerArray];
				}
				$log.error(format('[httpSV] nenhum dataHandler($dh) encontrado para o id={}', dataHandlerArray));
				return {};
			}
			return dataHandlers;
		}
		

	}

})();