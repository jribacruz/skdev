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
		
		var context = format('http://{}:{}/skdev',$location.host(),$location.port());

		/**
		 * Lista de actions;
		 */
		self.actions = {};

		/**
		 * 
		 */
		self.selectAction = selectAction;

		self.$dh = HttpSV.$dh();

		/**
		 * Request da listagem de actions.
		 */
		/*
		 * $http.get('http://localhost:8080/skdev/api/actions').success(function(data) {
		 * self.actions = data });
		 */
		HttpSV.get('actions');

		/**
		 * 
		 */
		function selectAction(id) {

			HttpSV.get('actions', {
				pathParams : {
					id : id
				}
			}).then(function(data) {
				$mdDialog.show({
					parent : angular.element(document.body),
					templateUrl : format('{}{}', context, data.component),
					clickOutsideToClose : false,
					controller : 'ActionCT',
					controllerAs : 'actionCT',
					locals : {
						actionDialog : data,
						actionId : id
					}
				});
			});

			/*
			 * $http.get('http://localhost:8080/skdev/api/actions/' +
			 * id).success( function(data) { $mdDialog.show({ parent :
			 * angular.element(document.body), template : data.template,
			 * clickOutsideToClose : false, controller : 'ActionCT',
			 * controllerAs : 'actionCT', locals : { actionDialog : data,
			 * actionId : id } }); });
			 */
		}

	}
})();