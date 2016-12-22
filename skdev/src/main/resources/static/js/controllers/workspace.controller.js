(function() {
	'use strict';

	angular.module('skdevMD').controller('WorkspaceCT', WorkspaceCT);

	WorkspaceCT.$inject = [ '$scope', '$log', '$mdDialog', 'HttpSV', '$injector' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdDialog
	 * @param HttpSV
	 * @returns
	 */
	function WorkspaceCT($scope, $log, $mdDialog, HttpSV, $injector) {
		$log.debug('[WorkspaceCT] Inicializando...');
		var self = this;

		self.projects = [];

		self.showActionListDialogByGroup = showActionListDialogByGroup;
		
		$scope.fn = new Function('HttpSV',"HttpSV.get('/projects').then(function(data){self.projects = data;})");

		init();
		
		
		function init() {
			/*
			HttpSV.get('/projects').then(function(data){
				self.projects = data;
			});*/
			//fn();
			//console.log($scope);
			//var angularFn = angular.bind(self,fn);
			//$scope.$eval(angularFn);
			var afn = angular.bind(this, $scope.fn);
			//$scope.$eval($scope.fn, HttpSV);
			afn.call($scope, HttpSV, self);
			//afn();
			//$scope.$apply(afn);
			//$injector.invoke([HttpSV, fn]);
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
				locals: {
					group: group,
					title: title
				}
			});
		}
		
	}
})();