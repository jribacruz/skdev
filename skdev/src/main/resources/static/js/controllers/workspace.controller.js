(function() {
	'use strict';

	angular.module('skdevMD').controller('WorkspaceCT', WorkspaceCT);

	WorkspaceCT.$inject = [ '$scope', '$log', '$mdDialog', 'httpSV', '$location', '$mdSidenav' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdDialog
	 * @param httpSV
	 * @returns
	 */
	function WorkspaceCT($scope, $log, $mdDialog, httpSV, $location, $mdSidenav) {
		$log.debug('[WorkspaceCT] Inicializando...');
		var self = this;

		self.projects = [];

		self.showActionListDialogByGroup = showActionListDialogByGroup;
		
		self.showActionExplorer = showActionExplorer;

		
		//  $scope.fn = new Function('httpSV', 'self', "(function(httpSV)  {  httpSV.get('/projects').then(function(data){self.projects = data;})})(httpSV);");
		 
		init();

		function init() {
			
		//	  var afn = angular.bind(this, $scope.fn, httpSV, self); 
		//	  afn();
			 
			// console.log($location.absUrl());
			httpSV.get('/projects', {
				queryParams : {
					workspace: httpSV.getWorkspace()
				}
			}).then(function(projects) {
				self.projects = projects;
			});

		}

		/**
		 * Exibe o dialog com a listagem de actions.
		 */
		function showActionListDialogByGroup(title, group) {
			$log.debug('[showActionListDialog] Listagem de Actions.')
			$mdDialog.show({
				parent : angular.element(document.body),
				templateUrl : '/skdev/partials/action.list.html',
				clickOutsideToClose : false,
				controller : 'ActionListCT',
				controllerAs : 'actionListCT',
				locals : {
					group : group,
					title : title
				}
			});
		}
		
		function showActionExplorer() {
			$mdSidenav('sidenav2').toggle();
		}

	}
})();