(function() {
	'use strict';

	angular.module("skdevMD").factory('notificationSV', notificationSV);

	notificationSV.$inject = [ '$log', '$mdToast', '$mdDialog' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function notificationSV($log, $mdToast, $mdDialog) {
		$log.debug('[notificationSV] Inicializando... ');

		var service = {
			show : show,
			confirm: confirm
		}
		
		return service;

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
		
		function confirm(text) {
			var confirm = $mdDialog.confirm()
	          .title('Confirmação')
	          .textContent(text)
	          .ariaLabel('Confrimação')
	          .ok('Sim')
	          .cancel('Não');
			return $mdDialog.show(confirm);
		}

	}

})();