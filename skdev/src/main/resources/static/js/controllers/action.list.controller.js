(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionListCT', ActionListCT);

	ActionListCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', 'HttpSV', '$location', 'group', 'title' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @param $mdDialog
	 * @param HttpSV
	 * @returns
	 */
	function ActionListCT($scope, $log, $http, $mdDialog, HttpSV, $location, group, title) {
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
			$log.debug(format('[ActionListCT] actiongroup={}', group));
			HttpSV.get('/actions',{
				queryParams: {
					group: group
				}
			}).then(function(data) {
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