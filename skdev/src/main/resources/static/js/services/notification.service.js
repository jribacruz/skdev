(function() {
	'use strict';

	angular.module("skdevMD").factory('notificationSV', notificationSV);

	notificationSV.$inject = [ '$log', '$mdToast' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function notificationSV($log, $mdToast) {
		$log.debug('[notificationSV] Inicializando... ');

		var service = {
			show : show
		}
		
		/**
		 * Exibe a mensagem de notificação.
		 */
		function show(message) {
		   $mdToast.show(
		      $mdToast.simple()
		      	.parent(angular.element(document.getElementById('content')))
		        .textContent(message)
		        .position('top right')
		        .hideDelay(3000)
		    );
		}

		return service;
	}

})();