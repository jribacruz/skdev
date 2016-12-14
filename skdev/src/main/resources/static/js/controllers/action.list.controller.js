(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionListCT', ActionListCT);

	ActionListCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', '$templateCache' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @returns
	 */
	function ActionListCT($scope, $log, $http, $mdDialog, $templateCache) {
		$log.debug('[ActionListCT] Inicializando...');
		var self = this;

		/**
		 * Lista de actions;
		 */
		self.actions = {};
		
		/**
		 * 
		 */
		self.selectAction = selectAction;

		/**
		 * Request da listagem de actions.
		 */
		$http.get('http://localhost:8080/skdev/api/actions').success(function(data) {
			self.actions = data
		});

		/**
		 * 
		 */
		function selectAction(id) {
			$http.get('http://localhost:8080/skdev/api/actions/' + id).success(function(data) {
				$mdDialog.show({
					parent : angular.element(document.body),
					template : data.template,
					clickOutsideToClose : false,
					controller : 'ActionCT',
					controllerAs : 'actionCT',
					locals: {
						actionDialog: data,
						actionId: id
					}
				});
			});
		}

	}
})();