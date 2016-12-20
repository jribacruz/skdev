(function() {
	'use strict';

	angular.module('skdevMD').controller('WorkspaceCT', WorkspaceCT);

	WorkspaceCT.$inject = [ '$scope', '$log', '$mdDialog', 'HttpSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdDialog
	 * @param HttpSV
	 * @returns
	 */
	function WorkspaceCT($scope, $log, $mdDialog, HttpSV) {
		$log.debug('[WorkspaceCT] Inicializando...');
		var self = this;

		self.projects = [];

		self.showActionListDialogByGroup = showActionListDialogByGroup;
		
		init();
		
		function init() {
			HttpSV.get('/projects').then(function(data){
				self.projects = data;
			});
		}
		
		/**
		 * Exibe o dialog com a listagem de actions.
		 */
		function showActionListDialogByGroup(group) {
			$log.debug('[showActionListDialog] Listagem de Actions.')
			$mdDialog.show({
				parent : angular.element(document.body),
				templateUrl : '/skdev/partials/action.list.html',
				clickOutsideToClose : false,
				controller : 'ActionListCT',
				controllerAs : 'actionListCT',
				locals: {
					group: group
				}
			});
		}
		
	}
})();