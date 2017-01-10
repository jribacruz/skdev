(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionListCT', ActionListCT);

	ActionListCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', 'httpSV', '$location' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @param $mdDialog
	 * @param HttpSV
	 * @returns
	 */
	function ActionListCT($scope, $log, $http, $mdDialog, httpSV, $location) {
		$log.debug('[ActionListCT] Inicializando...');
		var self = this;
		
		/**
		 * Lista de actions;
		 */
		self.actions = [];
		
		self.hide = hide;

		/**
		 * 
		 */
		self.selectAction = selectAction;
		
		init();

		function init() {
			httpSV.get('/actions').then(function(data) {
				self.actions = data;
			});
		}

		/**
		 * 
		 */
		function selectAction(id) {

			
		}
		
		function hide() {
		}

	}
})();