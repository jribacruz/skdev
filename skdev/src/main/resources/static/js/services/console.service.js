(function() {
	'use strict';

	angular.module("skdevMD").factory('consoleSV', consoleSV);

	consoleSV.$inject = [ '$log', '$mdToast' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function consoleSV($log, $mdToast) {
		$log.debug('[consoleSV] Inicializando... ');

		var service = {};

		/**
		 * Exibe informações no console
		 */
		function info(message) {

		}

		/**
		 * Exibe error no console.
		 */
		function error(message) {

		}

		/**
		 * Exibe aviso no console.
		 */
		function warn(message) {

		}

		return service;
	}

})();