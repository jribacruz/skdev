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

		var service = {
			get : get,
			getProjectName: getProjectName
		}
		

		return service;
		
		function getProjectName() {
			$log.debug(format('[HttpSV][getProjectName] location: {}', JSON.stringify(URI($location.absUrl()).search(true)))); 
			return URI($location.absUrl()).search(true).name;
		}
		
		/**
		 * Função Http GET
		 */
		function get(url, options) {
			
			$log.debug(format('[HttpSV] Method=GET, URL={} , url={}, options={}', url ,url,JSON.stringify(options)));
			
			options = options || {};
			var urlRequest = _buildUrlRequest(format('{}{}',context, url), options);
			
			return $http.get(urlRequest)
				.then(httpComplete)
				.catch(httpFailure);
			
			function httpComplete(response) {
				return response.data;
			}
			
			function httpFailure(error) {
				$log.debug('Request failed');
			}
		}
		
		/**
		 * 
		 */
		function _buildUrlRequest(url,options) {
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
				angular.forEach(options.queryParams, function(qryParam, url) {
					qArray.push(format('{}={}', url, qryParam));
				});
				if(url.endsWith('/')) {
					return format('{}?{}',url,qArray.join('&'));
				}
				return format('{}/?{}',url,qArray.join('&'));
			}
			return url;
		}
		
	}

})();