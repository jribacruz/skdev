(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionListCT', ActionListCT);

	ActionListCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', 'HttpSV', '$location' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @param $mdDialog
	 * @param HttpSV
	 * @returns
	 */
	function ActionListCT($scope, $log, $http, $mdDialog, HttpSV, $location) {
		$log.debug('[ActionListCT] Inicializando...');
		var self = this;
		
		var context = format('http://{}:{}/skdev', $location.host(), $location.port());

		/**
		 * Lista de actions;
		 */
		self.actions = {};

		/**
		 * 
		 */
		self.selectAction = selectAction;
		
		init();

		function init() {
			HttpSV.get('/actions').then(function(data) {
				self.actions = data;
			});
		}

		/**
		 * 
		 */
		function selectAction(id) {

			HttpSV.get('/actions/{id}', {
				pathParams : {
					id : id
				}
			}).then(function(data) {
				$mdDialog.show({
					parent : angular.element(document.body),
					templateUrl : format('{}{}', context, data.dialogTemplatePath),
					clickOutsideToClose : false,
					controller : 'ActionCT',
					controllerAs : 'actionCT',
					locals : {
						actionData : data,
						actionId : id
					}
				});
			});
		}

	}
})();